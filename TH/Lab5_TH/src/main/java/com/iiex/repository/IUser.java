package com.iiex.repository;

import com.iiex.model.Usertable;

public interface IUser extends genericDAO<Usertable> {
    Usertable isValidUser(Usertable usertable);
}
