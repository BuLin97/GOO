package com.yjxxt.service;


import com.yjxxt.pojo.NoteType;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * 云记类别管理
 * 云记类别遍历
 * 云记类别添加
 * 云记类别更新
 * 云记类别删除
 */
public class NoteTypeService {
    private UserService userService;

    private Map<Integer, NoteType> noteTypeMap;

    public NoteTypeService() {
        noteTypeMap = new HashMap<Integer, NoteType>();
        noteTypeMap.put(1, new NoteType(1, "java", 1));
        noteTypeMap.put(2, new NoteType(2, "php", 1));
        noteTypeMap.put(3, new NoteType(3, "scala", 2));
    }

    public void addNoteType(NoteType noteType) {
        /**
         * 1.参数校验
         *    类别名 不能为空 用户id 必须存在(UserService->List<User> 必须存在对应用户记录)
         * 2.当前用户下类别名称不可重复
         * 3.执行添加
         */

        if (null == noteType) {
            throw new RuntimeException("云记类型不能为空！");
        }
        if (StringUtils.isBlank(noteType.getTypeName())) {
            throw new RuntimeException("云记名不能为空！");
        }

    }

    /**
     * 根据登录用户查询云记类别
     *
     * @param userId
     */
    public void listNoteType(Integer userId) {


        for (Object key : noteTypeMap.keySet()) {
            if (userId.equals(noteTypeMap.get(key).getUserId())) {
                System.out.println(noteTypeMap.get(key).getTypeName());
            }
        }
    }


    public void updateNoteType(NoteType noteType) {
        /**
         * 1.参数校验
         *    类别名 不能为空
         *    用户id 必须存在(UserService->List<User> 必须存在对应用户记录)
         *    云记类别id 必须存在
         * 2.当前用户下类别名称不可重复
         * 3.执行更新
         */

        if(null == noteType){
            throw  new RuntimeException("类型不能为空！");
        }
        if(StringUtils.isBlank(noteType.getTypeName())){
            throw  new RuntimeException("云记类型名不能为空");
        }
        if(noteType.getId()==null || null== findNoteTypeByNoteTypeId(noteType.getId())){
            throw new RuntimeException("待更新的记录不存在！");
        }
        long count = noteTypeMap.entrySet().stream()
                .filter(n -> n.getValue().getTypeName().equals(noteType.getTypeName()))
                .filter(n->!(n.getValue().getId().equals(noteType.getId())))
                .count();
        if(count==1 ){
            throw  new RuntimeException("类名已存在!");
        }
        noteTypeMap.put(findNoteTypeByNoteTypeId(noteType.getId()).getKey(),noteType);
    }

    public void delNoteType(Integer id) {
        /**
         * 1.参数校验
         *    云记类别id 必须存在
         * 2.如果类别下存在云记记录 不允许删除
         * 3.执行删除
         */
        Map.Entry<Integer, NoteType> result = this.findNoteTypeByNoteTypeId(id);
        if (null == result) {
            throw new RuntimeException("待删除的记录不存在");
        }
        noteTypeMap.remove(result.getKey());
    }

    private Map.Entry<Integer, NoteType> findNoteTypeByNoteTypeId(Integer id) {
        Optional<Map.Entry<Integer, NoteType>> optionalNoteType = noteTypeMap.entrySet().stream()
                .filter(o -> o.getValue().getId().equals(id))
                .findFirst();
        return optionalNoteType.isPresent() ? optionalNoteType.get() : null;
    }


}
