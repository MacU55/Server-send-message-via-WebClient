package com.example.serverside2.controller;

import com.example.serverside2.service.ServerService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ServerController2 {

  @Autowired
  public ServerService2 serverService2;

  @GetMapping("/getResult")
  public String get() throws InterruptedException {
    return serverService2.getResult();
  }
}
