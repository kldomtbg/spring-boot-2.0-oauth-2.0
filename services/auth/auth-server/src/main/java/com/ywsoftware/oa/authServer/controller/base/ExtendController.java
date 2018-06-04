package com.ywsoftware.oa.authServer.controller.base;

import com.ywsoftware.oa.authServer.common.PaginatedResult;
import com.ywsoftware.oa.authServer.common.SpringUtil;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ExtendController<T> extends BaseController<T> {

    @SuppressWarnings("unchecked")
    public PaginatedResult relatedResult(PaginatedResult result) throws Exception {
        relatedFetch(result, null);
        return result;
    }

    private void relatedFetch(PaginatedResult result, List list) throws Exception {
        List<Field> fields;
        if (list == null) {
            list = (List) result.getData();
            fields = getRelatedFields();
        } else if (list.size() > 0) {
            fields = getRelatedFields(list.get(0).getClass());
        } else {
            return;
        }
        for (Field field : fields) {
            String name = field.getName();
            String typeName = field.getName().substring(0, name.length() - 2);
            if (result.getDictionary().get(typeName) == null) {
                List<Long> ids = new ArrayList<>();
                for (Object o : list) {
                    Long e = Long.parseLong(field.get(o).toString());
                    if (!ids.contains(e)) {
                        ids.add(e);
                    }
                }
                Object relatedService = SpringUtil.getBean(typeName + "Service");
                // 获取ids查询方法
                Method selectMethod = relatedService.getClass().getDeclaredMethod("selectAll", List.class);
                Object relatedResult = selectMethod.invoke(relatedService, ids);
                result.getDictionary().put(typeName, relatedResult);
                relatedFetch(result, (List) relatedResult);
            }
        }
    }
}
