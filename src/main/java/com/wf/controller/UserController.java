package com.wf.controller;

import com.wf.entry.User;
import com.wf.service.UserService;
import com.wf.utils.BaseException;
import com.wf.utils.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    private static final List<String> list = new ArrayList<>();

    @Autowired
    private UserService userService;

    @RequestMapping("/test")
    public ResultJson<List<User>> test() {
        User user = null;
        if (null == user) {
            throw new BaseException("数据错误！！！");
        }
        List<User> users = userService.selectUser();
        return new ResultJson<>(users);
    }

    /**
     * 必传 name pwd
     *
     * @param user
     * @return
     */
    @PostMapping("/login")
    public ResultJson<User> login(@RequestBody User user) {
        return new ResultJson<>(userService.login(user));
    }

    @GetMapping("/register")
    public ResultJson<Integer> Register(User user) {
        userService.register(user);
        return new ResultJson<>(1);
    }

    @RequestMapping("/home")
    public ResultJson<List<String>> home() {
        list.add("盛年不重来，一日难再晨。及时宜自勉，岁月不待人。——陶渊明");
        list.add("君子之交淡若水，小人之交甘若醴，君子淡以亲，小人甘以绝。——庄子");
        list.add("三更灯火五更鸡，正是男儿读书时，黑发不知勤学早，白首方悔读书迟。——颜真卿");
        list.add("有志者，事竟成，破釜沉舟，百二秦关终属楚；苦心人，天不负，卧薪尝胆，三千越甲可吞吴。——蒲松龄");
        list.add("天将降大任于斯人也，必先苦其心志，劳其筋骨，饿其体肤，空乏其身，行拂乱其所为，所以动心忍性，曾益其所不能。——孟子");
        list.add("富贵不能淫，贫贱不能移，威武不能屈，此之谓大丈夫。——孟子");
        list.add("人的生命是有限的，可是为人民服务是无限的，我要把有限的生命投入到无限的为人民服务之中去！——雷锋");
        list.add("读书如饭，善吃饭者长精神，不善吃者生疾病。——章学诚");
        list.add("天下兴亡，匹夫有责。——顾炎武");
        list.add("人不可有傲气，但不可无傲骨。——徐悲鸿");
        list.add("静以修身，俭以养德，非淡泊无以明志，非宁静无以致远。——诸葛亮");
        list.add("天时不如地利，地利不如人和。——《孟子·公孙丑》");
        list.add("三人行，必有我师焉，择其善者而从之，其不善者而改之。——孔子");
        list.add("少而好学，如日出之阳；壮而好学，如日中之光；志而好学，如炳烛之光。——刘向");
        list.add("古之立大志者，不惟有超世之才，亦必有坚韧不拔之志。——苏轼");
        list.add("盛年不重来，一日难再晨。及时当勉励，岁月不待人。——陶渊明");
        list.add("三军可夺帅也，匹夫不可夺志也。——孔子");
        list.add("天下事以难而废者十之一，以惰而废者十之九。——颜之推");
        list.add("时间就是生命，无端地空耗别人的时间，无异于谋财害命。——鲁迅");
        list.add("尺有所短；寸有所长。物有所不足；智有所不明。——屈原《卜居》");
        return new ResultJson<>(list);
    }

}
