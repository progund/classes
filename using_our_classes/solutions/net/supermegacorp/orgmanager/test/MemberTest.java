package net.supermegacorp.orgmanager.test;

import net.supermegacorp.orgmanager.Member;

public class MemberTest{

    public static void main (String[]args){
        Member ada     = new Member("Ada", "ada@lovelace.edu");
        Member charles = new Member("Charles", "charles __AT__ babbage.net");
        Member bert    = new Member("Bert", null);
        
        assert ada.email().equals("ada@lovelace.edu");
        assert charles.email()==null;
        assert bert.email()==null;
    }
    
}
