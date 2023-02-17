package com.tinne.dao;

import com.tinne.pojo.Phone;

import java.util.List;

public interface IPhoneDAO extends genericDAO<Phone>{

    /**
     * the phone with the highest selling price.
     * @return Phone
     */
    Phone topSell();

    /**
     * get a list of phones sorted by country name, if two phones have the
     * same country, sort descending by price
     * @return List<Phone>
     */
    List<Phone> sort();

    /**
     * check if there is a phone priced above 50 million VND
     * @return boolean
     */
    boolean above50Milion();

    /**
     *meets the criteria: has the color 'Pink'
     * and costs over 15 million. If there are no matching phones, return null.
     * @return Phone | null
     */
    Phone meetCriteria();
}
