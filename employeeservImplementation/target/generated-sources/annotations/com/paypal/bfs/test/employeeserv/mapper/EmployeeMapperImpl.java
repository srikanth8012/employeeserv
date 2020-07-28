package com.paypal.bfs.test.employeeserv.mapper;

import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.entity.Address;
import com.paypal.bfs.test.employeeserv.util.FormateUtill;
import java.text.ParseException;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-07-27T23:12:53-0400",
    comments = "version: 1.2.0.Final, compiler: Eclipse JDT (IDE) 3.21.0.v20200304-1404, environment: Java 1.8.0_131 (Oracle Corporation)"
)
public class EmployeeMapperImpl implements EmployeeMapper {

    private final FormateUtill formateUtill = new FormateUtill();

    @Override
    public com.paypal.bfs.test.employeeserv.entity.Employee voToDomain(Employee t) {

        com.paypal.bfs.test.employeeserv.entity.Employee employee = new com.paypal.bfs.test.employeeserv.entity.Employee();

        if ( t != null ) {
            try {
                employee.setDob( formateUtill.toDate( t.getDob() ) );
            }
            catch ( ParseException e ) {
                throw new RuntimeException( e );
            }
            employee.setAddress( voTodomainAddress( t.getAddress() ) );
            employee.setFirstName( t.getFirstName() );
            employee.setId( t.getId() );
            employee.setLastName( t.getLastName() );
        }

        return employee;
    }

    @Override
    public Employee domainToVo(com.paypal.bfs.test.employeeserv.entity.Employee t) {
        if ( t == null ) {
            return null;
        }

        Employee employee = new Employee();

        employee.setDob( formateUtill.toDateString( t.getDob() ) );
        employee.setAddress( domainToVoAdress( t.getAddress() ) );
        employee.setFirstName( t.getFirstName() );
        employee.setId( t.getId() );
        employee.setLastName( t.getLastName() );

        return employee;
    }

    @Override
    public com.paypal.bfs.test.employeeserv.api.model.Address domainToVoAdress(Address dataList) {
        if ( dataList == null ) {
            return null;
        }

        com.paypal.bfs.test.employeeserv.api.model.Address address = new com.paypal.bfs.test.employeeserv.api.model.Address();

        address.setAddressId( dataList.getAddressId() );
        address.setCity( dataList.getCity() );
        address.setCounty( dataList.getCounty() );
        address.setLine1( dataList.getLine1() );
        address.setLine2( dataList.getLine2() );
        address.setState( dataList.getState() );
        address.setZipCode( dataList.getZipCode() );

        return address;
    }

    @Override
    public Address voTodomainAddress(com.paypal.bfs.test.employeeserv.api.model.Address t) {

        Address address = new Address();

        if ( t != null ) {
            address.setAddressId( t.getAddressId() );
            address.setCity( t.getCity() );
            address.setCounty( t.getCounty() );
            address.setLine1( t.getLine1() );
            address.setLine2( t.getLine2() );
            address.setState( t.getState() );
            address.setZipCode( t.getZipCode() );
        }

        return address;
    }
}
