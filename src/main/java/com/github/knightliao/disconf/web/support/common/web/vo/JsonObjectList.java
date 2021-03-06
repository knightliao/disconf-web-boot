package com.github.knightliao.disconf.web.support.common.web.vo;

import java.util.HashMap;
import java.util.Map;

import com.github.knightliao.disconf.web.support.common.context.WebThreadContext;
import com.github.knightliao.disconf.web.support.constants.web.FrontEndInterfaceConstant;

/**
 * JSON LIST
 *
 * @author liaoqiqi
 * @version 2013-12-3
 */
public class JsonObjectList extends JsonObjectBase {

    /**
     *
     */
    private static final long serialVersionUID = -9082300329723012971L;

    private Map<String, Object> page = new HashMap<String, Object>();

    public JsonObjectList() {
        super();
        success = FrontEndInterfaceConstant.RETURN_OK;
    }

    public Map<String, Object> getPage() {
        return page;
    }

    public void setPage(Map<String, Object> page) {
        this.page = page;
    }

    /**
     * 通过ThreadContext将FE需要的Page数据传给前端
     *
     * @param totalCount
     */
    public void setPage(int totalCount) {

        //
        // 缓存中的数据
        //
        page.put(FrontEndInterfaceConstant.PAGE_NO, WebThreadContext.getContext(FrontEndInterfaceConstant.PAGE_NO));
        page.put(FrontEndInterfaceConstant.PAGE_SIZE, WebThreadContext.getContext(FrontEndInterfaceConstant.PAGE_SIZE));
        page.put(FrontEndInterfaceConstant.PAGE_ORDER_BY,
                WebThreadContext.getContext(FrontEndInterfaceConstant.PAGE_ORDER_BY));
        page.put(FrontEndInterfaceConstant.PAGE_ORDER,
                WebThreadContext.getContext(FrontEndInterfaceConstant.PAGE_ORDER));

        // 业务总数
        page.put(FrontEndInterfaceConstant.TOTAL_COUNT, totalCount);
    }

    public void addData(Object valueList) {

        page.put(FrontEndInterfaceConstant.RESULT, valueList);
    }

    public void addFootData(Object data) {

        page.put(FrontEndInterfaceConstant.FOOTR_RESULT, data);
    }
}
