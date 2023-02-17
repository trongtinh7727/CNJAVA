package com.tinne.dao;

import com.tinne.pojo.Manufacture;

public interface IManufacture extends genericDAO<Manufacture> {
    /**
     * check whether all manufacturers have more than 100 employees.
     * @return boolean
     */
    boolean chkMoreT100();

    /**
     * returns the sum of all employees of the manufactures.
     * @returns int
     */
    int countEmployee();

    /**
     * returns the last manufacturer in the list of manufacturers that meet
     * the criteria: based in the US. If there is no producer that meets the above criteria,
     * throw an InvalidOperationException.
     * @returns manufacturer | null | InvalidOperationException
     */
    Manufacture chkCriteria() ;
}
