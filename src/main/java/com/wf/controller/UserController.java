package com.wf.controller;

import com.alibaba.excel.EasyExcel;
import com.wf.core.ResultBody;
import com.wf.dto.BasCommodityImportDto;
import com.wf.entry.User;
import com.wf.service.UserService;
import com.wf.utils.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class UserController {

    private static final List<String> list = new ArrayList<>();

    @Autowired
    private UserService userService;

    static {
        list.add("有些路很远，走下去会很累。可是，不走，会后悔");
        list.add("世界这么大，能遇见，不容易,且行且珍惜");
        list.add("当我已经给你天天分享日常的时候你就应该知道我已经沦陷了" + " -- " +
                "You should know I'm falling when I'm already sharing my daily routine with you");
        list.add("热爱的事情，一定不能半途而废");
        list.add("唯有热爱，能抵漫长岁月");
        list.add("但行好事,莫问前程");
        list.add("生活有些沉闷，还好跑起来有风");
        list.add("一群有情有义的人，在一起做一些有意义的事情");
        list.add("我们的征途，是那星辰大海");
        list.add("人不可有傲气，但不可无傲骨");
        list.add("一天中黎明前是最黑暗的，但也是最接近光明的时候，暴风雨前是最宁静的，但彩虹总是在风雨后。");
        list.add("世上最重要的事，不在于我们在何处，而在于我们朝着什么方向走");
        list.add("追求源于热爱");
        list.add("这山河烂漫秋风暖阳人间朝暮你愿不愿意和我一起看看");
        list.add("不忘初心，方得始终");
        list.add("没关系，天空越黑，星星越亮");
        list.add("没有一颗心会因为追求梦想而受伤，当你真心渴望某样东西时，整个宇宙都会来帮忙");
        list.add("自能生羽翼，何必仰云梯");
        list.add("不要因为别人一句话，而夺走你今天的快乐");
        list.add("永远相信美好的事情即将发生");
        list.add("须知少年凌云志，曾许人间第一流");
        list.add("少年最好的地方就是：虽然嘴上说着放弃，心底却总会憋着一口气");
        list.add("每个人都在做着各自的斗争呢，所以无论如何都不要服输");
        list.add("时间不在于你拥有多少，而在于你怎样去使用");
        list.add("我不是Superhero,我为自己代言");
        list.add("明天你好！");
    }

    @RequestMapping("/all")
    public List<User> get() throws ParseException {
        String[] time = {"2021-01-07", "2021-01-15"};
        List<User> all = userService.getAll(time);
        return all;
    }

    @RequestMapping("/test")
    public ResultJson<List<User>> test() {
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

    @GetMapping("/home")
    public ResultJson<String> home() {
        int i = new Random().nextInt(list.size());
        return new ResultJson<>(list.get(i));
    }

    //EasyExcel读
    @PostMapping(value = "/upload", headers = "content-type=multipart/form-data")
    public String upload(MultipartFile file) throws IOException {
        List<Object> list = EasyExcel.read(file.getInputStream(), BasCommodityImportDto.class, null).sheet(0).doReadSync();
        System.out.println("==========");
        return "success";
    }

    @GetMapping("/add")
    public void insert(String name){
        userService.add(name);
    }

}
