package com.cyreno.service;

import com.cyreno.model.Direction;
import com.cyreno.model.Robot;
import com.cyreno.model.Surface;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/rest/mars")
public class RobotController {

    @PostMapping("/{commands}")
    public String processCommands(@PathVariable String commands) {

        Surface surface = new Surface(5, 5);
        Robot robot = new Robot(0, 0, Direction.NORTH, surface);

        new CommandExecutor(robot).executeCommands(commands);

        return RobotResponseFormatter.getResponseAsText(robot);

    }

}
