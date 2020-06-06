package tyella.java.core.map;

import java.util.HashMap;
import java.util.Map;
import com.sun.org.apache.xpath.internal.operations.Bool;

public class mapTransfer {

    public static void main(String[] args){
        Map<String,Object> showInfo=new HashMap<>();
        showInfo.put("aa",true);
        showInfo.put("bb","cc");
        System.out.println("aa="+(Boolean)showInfo.get("aa"));
        //System.out.println("bb="+(Boolean)showInfo.get("bb"));
        System.out.println("dd="+(Boolean)showInfo.get("dd"));

        System.out.println("aa="+(boolean)showInfo.get("aa"));
        //System.out.println("bb="+(Boolean)showInfo.get("bb"));
        //System.out.println("dd="+(boolean)showInfo.get("dd"));

        if((Boolean)showInfo.get("dd")){
            System.out.println("ddddddddddddddd");
        }
    }
}
