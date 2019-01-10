package entity;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016092500590407";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDA7csZvXUhcTu6TGReeFvAhhZ7byCvU0gUn6Qs+wD5KKNu3QKbP8JfP7DjG3HkGa8rZEJX/aUQojCF8JG6wUpWAmScdwc0/LyPEw4IudXIw/AvfYRyGcM6xvdyaNKn7cl9CSTwNshKwawFK4VWsuJBpXAjhM5DhyLtbpnTHJI5sb2zdf8VRT46rzmv4v9EMPXp9+gwq3yOPcmJrdVTP1VxWWsG+TPsePmzQgoWqrLNIf7Of1zLAxU9HUJ7CZtUuSGJ4FqXtxuYY/B55jAM2Mnp5Nua5PvZaFQHJ8vfxYUMchTs5g4Wppsk8Qp2OvXEPFpGIEdLCMt98q50oIUU2UdtAgMBAAECggEASKdEHOVj/rwNqhKqmYjpxI66WLF4tY2/T0TvJqE/tJTBNzazjJNuN0Bc9KmZMjUZ6lVPRqOWTbVGYKo/tvyjadBs4x9P73xd5eNfHZoeEAT5pmi2P+HDy5ayCLvA2MyLXDLdXjjDJKPai/ffts6WtfH/UODqbDOvy4ojE4Vm66KDS8/SyeUa8bm5JSd0J4ewOTowRkz/s0eLv1FRlEW7pNtccU0Z4ka4/5AxAF8vmXovE7UzRVbHY2cYRiIsBV/w3eBbFb4ZCVFyFpJv/o7FoN9TvSAbLGdAw0T2EHSlh1OWt4tUOFQWBq6m4A/DWHFNRhpVCV2SyFAFJsHxZmzkYQKBgQD4TTB08w7Ewju+LoQsoO8uWrksWN2sMJvvDbJEzM4l0KKEw/CXyrZz6EGK0m3pllbHmIuZiIsiB0WF3GLjk8fs3NkpqYUK7iyzQNDpTs4/+0TjQUkcLqOX8IRA2wjo74ezc97s+UQPNJmoH5Gg2g95wv6GGmZUueeZaBcnYfU/NwKBgQDG6RoniHKrWtxs1ENs1EJyKVFjoLtpoYT8WlKFQ7tKPPrubcDhWHBWGJPzWk8K2JcuGsXNG7HSk2Ed/I/K2CLY65V+3tTjh1ZntazmToai/xZBPsQIsktxtdJ/Qwc7UITUs9dK5l1V+MHK6M6jaettgU9x/JPmJlkcnO9Zdn9YewKBgGFipOa5jclOBPCKffyjAixEGOxzzj2CsyYHUSv6x7+9HIDF+M8QCo9bQJmZ/tHmzRJrmhUVoLwv7eyai46Gn5se422btzqaP53uhgF7jxk5C8O2D16mTDODeduWDOCPUcHoaD65ZSAxmTJ/bzaPUBKJkBo4sHn6kANy9+HSYcXxAoGAOy5hvL9pNriK+spQ4VFqD6Nhdt38xNnswlRxVvsm/1iTZFs9Vw7EJamcY3xMJjL5EBuhHHyP9NIqxAxAEB8shxPY3+2Ws7exqpuwPLnCbz6sNW9iTiAWOFfbsEeWIDy9uLdlaACQZqLjreaEjLRX+rXNmGGI86IXQ18iC6EpFH8CgYEA3D6+Gv9VGQp46jrmUgGBCkq+FyYEZ65YFOZ2LE804Q5GR16EK8+YtVOLllU+14yMGip8Diig0k5ZjFEdspmxClOu6uZVfdhOPMtjI7/WE6CZ70Ou5+Pu3mHIo5EaqHlvZ6196WwyniVZg51XfZoLL5MltHWbScMrG+oiOV/FJ2E=";
/*    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDA7csZvXUhcTu6\r\n" + 
    		"TGReeFvAhhZ7byCvU0gUn6Qs+wD5KKNu3QKbP8JfP7DjG3HkGa8rZEJX/aUQojCF\r\n" + 
    		"8JG6wUpWAmScdwc0/LyPEw4IudXIw/AvfYRyGcM6xvdyaNKn7cl9CSTwNshKwawF\r\n" + 
    		"K4VWsuJBpXAjhM5DhyLtbpnTHJI5sb2zdf8VRT46rzmv4v9EMPXp9+gwq3yOPcmJ\r\n" + 
    		"rdVTP1VxWWsG+TPsePmzQgoWqrLNIf7Of1zLAxU9HUJ7CZtUuSGJ4FqXtxuYY/B5\r\n" + 
    		"5jAM2Mnp5Nua5PvZaFQHJ8vfxYUMchTs5g4Wppsk8Qp2OvXEPFpGIEdLCMt98q50\r\n" + 
    		"oIUU2UdtAgMBAAECggEASKdEHOVj/rwNqhKqmYjpxI66WLF4tY2/T0TvJqE/tJTB\r\n" + 
    		"NzazjJNuN0Bc9KmZMjUZ6lVPRqOWTbVGYKo/tvyjadBs4x9P73xd5eNfHZoeEAT5\r\n" + 
    		"pmi2P+HDy5ayCLvA2MyLXDLdXjjDJKPai/ffts6WtfH/UODqbDOvy4ojE4Vm66KD\r\n" + 
    		"S8/SyeUa8bm5JSd0J4ewOTowRkz/s0eLv1FRlEW7pNtccU0Z4ka4/5AxAF8vmXov\r\n" + 
    		"E7UzRVbHY2cYRiIsBV/w3eBbFb4ZCVFyFpJv/o7FoN9TvSAbLGdAw0T2EHSlh1OW\r\n" + 
    		"t4tUOFQWBq6m4A/DWHFNRhpVCV2SyFAFJsHxZmzkYQKBgQD4TTB08w7Ewju+LoQs\r\n" + 
    		"oO8uWrksWN2sMJvvDbJEzM4l0KKEw/CXyrZz6EGK0m3pllbHmIuZiIsiB0WF3GLj\r\n" + 
    		"k8fs3NkpqYUK7iyzQNDpTs4/+0TjQUkcLqOX8IRA2wjo74ezc97s+UQPNJmoH5Gg\r\n" + 
    		"2g95wv6GGmZUueeZaBcnYfU/NwKBgQDG6RoniHKrWtxs1ENs1EJyKVFjoLtpoYT8\r\n" + 
    		"WlKFQ7tKPPrubcDhWHBWGJPzWk8K2JcuGsXNG7HSk2Ed/I/K2CLY65V+3tTjh1Zn\r\n" + 
    		"tazmToai/xZBPsQIsktxtdJ/Qwc7UITUs9dK5l1V+MHK6M6jaettgU9x/JPmJlkc\r\n" + 
    		"nO9Zdn9YewKBgGFipOa5jclOBPCKffyjAixEGOxzzj2CsyYHUSv6x7+9HIDF+M8Q\r\n" + 
    		"Co9bQJmZ/tHmzRJrmhUVoLwv7eyai46Gn5se422btzqaP53uhgF7jxk5C8O2D16m\r\n" + 
    		"TDODeduWDOCPUcHoaD65ZSAxmTJ/bzaPUBKJkBo4sHn6kANy9+HSYcXxAoGAOy5h\r\n" + 
    		"vL9pNriK+spQ4VFqD6Nhdt38xNnswlRxVvsm/1iTZFs9Vw7EJamcY3xMJjL5EBuh\r\n" + 
    		"HHyP9NIqxAxAEB8shxPY3+2Ws7exqpuwPLnCbz6sNW9iTiAWOFfbsEeWIDy9uLdl\r\n" + 
    		"aACQZqLjreaEjLRX+rXNmGGI86IXQ18iC6EpFH8CgYEA3D6+Gv9VGQp46jrmUgGB\r\n" + 
    		"Ckq+FyYEZ65YFOZ2LE804Q5GR16EK8+YtVOLllU+14yMGip8Diig0k5ZjFEdspmx\r\n" + 
    		"ClOu6uZVfdhOPMtjI7/WE6CZ70Ou5+Pu3mHIo5EaqHlvZ6196WwyniVZg51XfZoL\r\n" + 
    		"L5MltHWbScMrG+oiOV/FJ2E=";
*/	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAsMJ+p0NXip8oI0u88ZYHhSb4cKNr3J9q5OUvi220XDd7BcZP7LaoLA7UTenPmO8rnlh3vLXPqX9Xdml8ESzF+Ndn0OmChoqF999r9555dEHNPpkUev8R81WU5sHCDByyFmtMKSN6vxSVt0Iv4dtsfOOeZQ6kZgn0AtpsZlulOdfVJg2VBITkOeK2qGrUCsX1VczmZf+sV6fsfxSborDsz4AnW9aUdJboWoV5EbThTE7tH//iv94MquNN6MTZhFHJXIXj4mUAYmszMADLLdXT7Wrf64dKfGnNSE/ga7KEu+G0EUo1ToM0L1PdmbIMPHgp3jPz5yVMW7L8r2GPE6khqQIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://localhost:8080/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://localhost:8080/alipay.trade.page.pay-JAVA-UTF-8/return_url.jsp";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

