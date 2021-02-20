package com.xp.note.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xp.note.entity.TNote;
import com.xp.note.vo.PageVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xp123
 * @since 2021-02-08
 */
public interface TNoteService extends IService<TNote> {

    /*****
     *  新增或者更新笔记
     * @param note
     * @return
     */
    void saveOrUpdateNote(TNote note);

    /********
     *  根据日记id 删除日记
     * @param id
     */
    void deleteNote(String id);

    /******
     *  分页查询日记信息
     * @param param
     * @return
     */
    Page<TNote> selectByPage(PageVo<TNote> param);
}
