package com.kbop.util;

import com.kbop.bean.JsonMsg;
import com.kbop.common.JsonMsgCode;
import com.kbop.common.JsonMsgConsts;

/**
 * @author WallaceTang
 */
public class JsonMsgFactory {

    public static JsonMsg OK_MSG() {
        return new OK_JsonMsg();
    }

    public static JsonMsg ERROR_MSG() {
        return new ERROR_JsonMsg();
    }

    public static JsonMsg FAIL_MSG() {
        return new FAIL_JsonMsg();
    }

    /**
     * 默认 JsonMsg
     *
     * @return code: 0 msg: ok
     */
    public static JsonMsg defJsonMsg() {
        JsonMsg jsonMsg = new JsonMsg();
        jsonMsg.setCode(JsonMsgCode.OK);
        jsonMsg.setMsg(JsonMsgConsts.MSG_OK);
        return jsonMsg;
    }

    /**
     * 默认 JsonMsg
     *
     * @param e   data对象
     * @param <E>
     * @return
     */
    public static <E> JsonMsg<E> defJsonMsg(E e) {
        JsonMsg<E> jsonMsg = new JsonMsg<E>();
        jsonMsg.setCode(JsonMsgCode.OK);
        jsonMsg.setMsg(JsonMsgConsts.MSG_OK);
        jsonMsg.setData(e);
        return jsonMsg;
    }

    public static <E> JsonMsg<E> newJsonMsg() {
        JsonMsg<E> jsonMsg = new JsonMsg<E>();
        return jsonMsg;
    }

    public static <E> JsonMsg<E> newJsonMsg(E e) {
        JsonMsg<E> jsonMsg = new JsonMsg<E>();
        jsonMsg.setData(e);
        return jsonMsg;
    }


    static class OK_JsonMsg extends JsonMsg {
        public OK_JsonMsg() {
            super(JsonMsgCode.OK, JsonMsgConsts.MSG_OK, null);
        }

        @Override
        public void setCode(Integer code) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void setMsg(String msg) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void setData(Object data) {
            throw new UnsupportedOperationException();
        }
    }

    static class ERROR_JsonMsg extends JsonMsg {
        public ERROR_JsonMsg() {
            super(JsonMsgCode.ERROR, JsonMsgConsts.MSG_ERROR, null);
        }

        @Override
        public void setCode(Integer code) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void setMsg(String msg) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void setData(Object data) {
            throw new UnsupportedOperationException();
        }
    }

    static class FAIL_JsonMsg extends JsonMsg {
        public FAIL_JsonMsg() {
            super(JsonMsgCode.FAIL, JsonMsgConsts.MSG_FAIL, null);
        }

        @Override
        public void setCode(Integer code) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void setMsg(String msg) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void setData(Object data) {
            throw new UnsupportedOperationException();
        }
    }
}
