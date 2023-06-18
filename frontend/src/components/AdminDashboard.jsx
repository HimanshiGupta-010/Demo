import React from 'react';
import { Link } from 'react-router-dom';

const AdminDashboard = () => {
    return (
        <div className="min-vh-100 d-flex align-items-center justify-content-center">
            <div className="text-center">
                <h1 className="display-4 font-weight-bold mb-4">Welcome to the Admin Dashboard</h1>
                    <div className="d-flex justify-content-center gap-3">
                        <Link to="/manage-employees">
                            <button className="btn btn-primary btn-lg">
                                Manage Employees
                                </button>
                        </Link>
                        <Link to="/demo">
                            <button className="btn btn-primary btn-lg">
                                Manage Items
                            </button>
                        </Link>
                        <Link to="/assign-unassign-item">
                            <button className="btn btn-primary btn-lg">
                                Assign/Unassign Item
                            </button>
                        </Link> 
                    </div>
            </div>
        </div>
    );
};

export default AdminDashboard;