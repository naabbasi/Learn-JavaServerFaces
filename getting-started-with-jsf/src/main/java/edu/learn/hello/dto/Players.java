package edu.learn.hello.dto;

public class Players {
private String player;
private byte age;
private String birthplace;
private String residence;
private short height;
private byte weight;
private String coach;
private Date born;
private int ranking;
public Players() {}
public Players(int ranking, String player, byte age, String
birthplace, String residence, short height, byte weight,
String coach, Date born) {
this.ranking = ranking;
this.player = player;
this.age = age;
this.birthplace = birthplace;
this.residence = residence;
this.height = height;
this.weight = weight;
this.coach = coach;
this.born = born;
}
...
//getters and setters
}