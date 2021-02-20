package com.xp.note.service.impl;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xp.note.entity.TNote;
import com.xp.note.mapper.TNoteMapper;
import com.xp.note.service.TNoteService;
import com.xp.note.util.UuIdUtil;
import com.xp.note.vo.PageVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author xp123
 * @since 2021-02-08
 */
@Service
@Slf4j
public class TNoteServiceImpl extends ServiceImpl<TNoteMapper, TNote> implements TNoteService {

    @Autowired
    TNoteMapper noteMapper;

    @Override
    public void saveOrUpdateNote(TNote note) {
        String noteId =  note.getId();
        if(noteId!=null && StringUtils.hasLength(noteId)){

            TNote tNote = noteMapper.selectById(noteId);
            if(null!=tNote){ // 证明应该更新
                note.setId(noteId);
                note.setUpdateTime(new Date());
            }
        }else{
            note.setId(UuIdUtil.getUuId32());
            note.setCreateTime(new Date());
        }

        saveOrUpdate(note);
        log.info("保存成功！");
    }


    @Override
    public void deleteNote(String id) {
        removeById(id);
    }

    @Override
    public Page<TNote> selectByPage(PageVo<TNote> pageVo) {

        TNote params = pageVo.getParams();
        QueryWrapper<TNote> wrapper = new QueryWrapper<>();

        if(null != params){

            // 标题
            if(null!=params.getNoteTitle() && StringUtils.hasLength(params.getNoteTitle())){
                wrapper.like("note_title",params.getNoteTitle());
            }
            // 标签
            if(null!= params.getNoteFlag() && StringUtils.hasLength(params.getNoteFlag())){
                wrapper.like("note_flag",params.getNoteFlag());
            }

            // 开始时间
            if(null!= params.getStartTime() && StringUtils.hasLength(params.getStartTime()) ){

                // 开始转换时间
                Date start = DateUtil.parse(params.getStartTime());

                wrapper.ge("create_time",start);
            }

            // 结束时间
            if(null!=params.getEndTime() && StringUtils.hasLength(params.getEndTime())){
                // 开始转换时间
                Date end = DateUtil.parse(params.getEndTime());

                wrapper.le("create_time",end);
            }

        }
        PageVo<TNote> tNotePageVo = noteMapper.selectPage(pageVo, wrapper);

        return tNotePageVo;
    }

    public static void main(String[] args) {

        String s = "2021-02-19 17:06:03";
        DateTime parse = DateUtil.parse(s);
        System.out.println(DateUtil.parse(s));
    }
}

