package com.isoft.biz.handler.common;

import com.isoft.biz.handler.LogicHandler;
import com.isoft.biz.method.BLHMethod;
import com.isoft.biz.method.Role;
import com.isoft.dictionary.FuncIdEnum;

public interface ISelectItemHandler extends LogicHandler {
	BLHMethod METHOD_GETSELECTITEMS = new BLHMethod("getSelectItems",
			FuncIdEnum.DEFAULT_FUNID, Role.ANYONE);
}
