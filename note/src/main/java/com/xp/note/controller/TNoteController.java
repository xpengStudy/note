package com.xp.note.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xp.note.entity.TNote;
import com.xp.note.service.TNoteService;
import com.xp.note.util.MessageCode;
import com.xp.note.util.SimpleMessage;
import com.xp.note.vo.PageVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;


/**
 * <p>
 *  笔记 controller
 * </p>
 *
 * @author xp123
 * @since 2021-02-08
 */
@RestController
@RequestMapping("/tNote")
@Slf4j
@Api(description = "笔记接口")
public class TNoteController {

    @Autowired
    private TNoteService noteService;

    @RequestMapping("/saveOrUpdateNote")
    @ApiOperation(value = "新增或者保存笔记", notes = "新增||保存笔记")
    public SimpleMessage saveOrUpdateNote(@RequestBody TNote note){

        if(null == note){
            return SimpleMessage.fail("该保存对象属性为空！");
        }
        try {
            noteService.saveOrUpdateNote(note);
        } catch (Exception e) {
            log.error("新增错误！,{}",e.getMessage());
            return SimpleMessage.fail(e.getMessage());
        }
        return SimpleMessage.info(MessageCode.SUCCESS);

    }

    @DeleteMapping("/deleteNoteById/{id}")
    @ApiOperation(value = "删除笔记id" , notes = "根据笔记的id找到笔记并且删除")
    public SimpleMessage deleteNote(@PathVariable("id") String id){

        if(!StringUtils.hasLength(id)){
            return SimpleMessage.fail("NOTE 的id 为空！");
        }

        try {
            noteService.deleteNote(id);
        } catch (Exception e) {
            log.error("删除错误!,{}",e.getMessage());
            return SimpleMessage.fail(e.getMessage());
        }

        return SimpleMessage.info(MessageCode.SUCCESS);
    }

    @RequestMapping("/selectNoteByPage")
    @ApiOperation(value = "查询所有的日记，按条件查询")
    public SimpleMessage  selectNoteByPage(@RequestBody PageVo<TNote> pageVo){

        Page<TNote> tNotePage = null;
        try {
            tNotePage = noteService.selectByPage(pageVo);
        } catch (Exception e) {
            log.error("查询错误！,{}",e.getMessage());
            return SimpleMessage.warn("查询错误！",e.getMessage());
        }
        return SimpleMessage.info(tNotePage);

    }





}

