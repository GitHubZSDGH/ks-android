package hlks.hualiangou.com.ks_android;

import com.google.gson.annotations.Since;

/**
 * 项目名称:
 * 类描述:
 * 创建人:lenovo
 * 创建时间:2017/11/13
 * 修改人:
 * 修改内容:
 */
public class BaseBean  {
    protected String code;
    @Since(2.0)
    protected String message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
