import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import EmployeeServices from '../services/EmployeeService'

const ListEmployee = () => {
    const [employees, setEmployees] = useState([]);

    useEffect(() => {
        getAllEmployees();
    }, [])

    const getAllEmployees = () =>
    {
        EmployeeServices.getAllEmployees().then((response) => {
            setEmployees(response.data)
            console.log(response.data)
        }).catch(error => {
            console.log(error);
        })
    }

    const deleteEmployee = (employeeId) => {
        EmployeeServices.deleteEmployee(employeeId).then((response) => {
            getAllEmployees();
        })
        .catch((error) => {
            console.log(error);
        });
    };

    // ItemService.updateItem(id, item).then((response) => {
    //     navigate('/list-items')
    //     }).catch(error => {
    //         console.log(error);
    //     })

    const unassignItem = (employeeId, name, employeeItemId) => {
        const employee = { name }
        console.log(employee);

        EmployeeServices.updateEmployee(employeeId, employee).then((response) => {
         console.log("Unassigned")
        }).catch(error => {
            console.log("Eror Caught")
        })
        
    }

    return (
        <div className="bg-dark min-vh-100 py-4">
            <div className="container">
                <h2 className="text-center text-2xl font-weight-bold mb-4 text-white">Assign - Unassign Item</h2>
                <Link to = "/add-employee" className = "btn btn-primary mb-2">Add Employee</Link>
                <Link to = "/list-items" className = "btn btn-primary mb-2"  style={{ marginLeft: "10px" }}>
                    List Items
                </Link>
                <table className="table table-bordered table-striped">
                    <thead className="bg-gray-200">
                        <tr>
                            <th>Employee ID</th>
                            <th>Employee  Name</th>
                            <th>Item ID</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        {employees.map((employee) => (
                            <tr key={employee.emp_id}>
                                <td>{employee.emp_id}</td>
                                <td>{employee.name}</td>
                                <td>{employee.itemId}</td>
                                <td>
                                    <Link className="btn btn-info" to={`/edit-employee/${employee.emp_id}`}>
                                        Update
                                    </Link>
                                    <Link style={{ marginLeft: "10px" }} className="btn btn-info" 
                                    to={`/assign/${employee.emp_id}`}>
                                        Assign
                                    </Link>
                                    <button className="btn btn-danger"
                                        onClick={() => unassignItem(employee.emp_id, employee.name, employee.itemId)}
                                        style={{ marginLeft: "10px" }}>
                                        Unassign
                                    </button>
                                    <button className="btn btn-danger" style={{ marginLeft: "10px" }}
                                        onClick={() => deleteEmployee(employee.emp_id)}>
                                        Delete
                                    </button>
                                </td>
                            </tr>
                        ))}
                    </tbody>
                </table>
            </div>
        </div>
    );
};

export default ListEmployee;