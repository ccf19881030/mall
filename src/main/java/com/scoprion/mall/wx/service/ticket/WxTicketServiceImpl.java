package com.scoprion.mall.wx.service.ticket;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.scoprion.constant.Constant;
import com.scoprion.mall.domain.Ticket;
import com.scoprion.mall.domain.TicketSnapshot;
import com.scoprion.mall.domain.TicketUser;
import com.scoprion.mall.wx.mapper.WxTicketMapper;
import com.scoprion.mall.wx.mapper.WxTicketSnapshotMapper;
import com.scoprion.result.BaseResult;
import com.scoprion.result.PageResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;


/**
 * @author by Administrator
 * @created on 2017/11/2/002.
 */

@Service
public class WxTicketServiceImpl implements WxTicketService {

    @Autowired
    private WxTicketMapper wxTicketMapper;

    @Autowired
    private WxTicketSnapshotMapper wxTicketSnapshotMapper;


    /**
     * 用户优惠券列表
     *
     * @param pageNo
     * @param pageSize
     * @param userId   用户id
     * @return
     */
    @Override
    public PageResult findByUserId(Integer pageNo, Integer pageSize, Long userId) {
        PageHelper.startPage(pageNo, pageSize);
        Page<Ticket> page = wxTicketMapper.findByUserId(userId);
        return new PageResult(page);
    }

    /**
     * 领取优惠券
     *
     * @param userId
     * @param ticketId
     * @return
     */
    @Override
    public BaseResult getTicket(Long ticketId, Long userId) {
        TicketUser ticketUser = wxTicketMapper.findByTicketIdAndUserId(ticketId, userId);
        if (ticketUser != null) {
            return BaseResult.error("add_error", "已经领取过了");
        }
        Ticket ticket = wxTicketMapper.findById(ticketId);
        if (ticket == null) {
            return BaseResult.error("add_error", "领取失败,找不到该优惠券");
        }
        TicketSnapshot snapshot = new TicketSnapshot();
        BeanUtils.copyProperties(ticket, snapshot);
        int result = wxTicketSnapshotMapper.add(snapshot);
        if (result > 0) {
            ticketUser = new TicketUser();
            ticketUser.setNum(1);
            ticketUser.setTicketId(ticketId);
            ticketUser.setUserId(userId);
            ticketUser.setStatus(Constant.STATUS_ZERO);
            int addResult = wxTicketMapper.addTicketUser(ticketUser);
            if (addResult > 0) {
                return BaseResult.success("领取成功");
            }
        }
        return BaseResult.error("add_error", "领取失败");
    }

    @Override
    public BaseResult findByTicketId(Long userId, Long ticketId) {
//        TicketUser ticketUser = wxTicketMapper.findByTicketIdAndUserId(ticketId, userId);
//        Date date = ticketUser.getUseDate();
        //当前时间
//        Date currentDate = new Date();
//        if (date.getTime() > currentDate.getTime()) {
//            return BaseResult.error("date_out", "还未到优惠卷的使用时间");
//        }
        return BaseResult.error("fail", "");
    }

}