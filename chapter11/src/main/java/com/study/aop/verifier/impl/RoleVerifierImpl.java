package com.study.aop.verifier.impl;

import com.study.aop.verifier.RoleVerifier;
import com.study.game.pojo.Role;

public class RoleVerifierImpl implements RoleVerifier {

    public boolean verifier(Role role) {
        return role != null;
    }
}
