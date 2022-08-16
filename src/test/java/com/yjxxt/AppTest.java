package com.yjxxt;

import com.yjxxt.pojo.NoteType;
import com.yjxxt.service.NoteTypeService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    private NoteTypeService noteTypeService=null;
    /**
     * Rigorous Test :-)
     */
    @Before
    public void init(){
        System.out.println("测试方法执行前执行.......");
        noteTypeService=new NoteTypeService();
    }
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

   @Test
    public  void list(){
       noteTypeService.listNoteType(1);
    }

    @Test
    public void delUser(){
        System.out.println("记录删除前.........");
        noteTypeService.listNoteType(1);
        noteTypeService.delNoteType(2);
        System.out.println("记录删除后.........");
        noteTypeService.listNoteType(1);
    }

    @Test
    public void updateUser(){
        System.out.println("记录更新前.........");
        noteTypeService.listNoteType(1);
        noteTypeService.updateNoteType(new NoteType(3, "python", 1));
        System.out.println("记录更新后......");
        noteTypeService.listNoteType(1);
    }
}
