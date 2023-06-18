import React, { useEffect } from 'react';
import {useState} from 'react';
import {Link} from 'react-router-dom';
import {useNavigate} from 'react-router-dom';
import { useParams } from "react-router-dom";
import ItemService from '../services/ItemService';

const AddItem = () => {

    const[name, setname] = useState('')
    const[status, setStatus] = useState(false)
    const navigate = useNavigate();
    const {id} = useParams();


    
    const saveOrUpdateItem = (e) => {
        e.preventDefault();
        const item = {name, status}
        if(id)
        {
            ItemService.updateItem(id, item).then((response) => {
            navigate('/list-items')
            }).catch(error => {
                console.log(error);
            })
        }
        else
        {
            // console.log(employee);
            ItemService.createItem(item).then((response) => {
                console.log(response.data)
                navigate('/list-items')
            }).catch(error => {
                console.log(error)
            })
        }
    }
    
    useEffect(() => {
        ItemService.getItemById(id).then((response) => {
            setname(response.data.name)
        }).catch(error => {
            console.log(error)
        })
    }, [])

    const title = () => {
        if(id){
            return <h2 className='text-center'>Update Item</h2>
        }
        else{
            return <h2 className='text-center'>Add Item</h2>
        }
    }

    return (
        <div>
            <br/>
            <br/>
            <div className = 'container'>
                <div className = 'row'>
                    <div className = 'card col-md-6 offset-md-3 offset-md-3'>
                    {
                        title()
                    }
                        <div className = 'card-body'>
                            <form>
                                <div className='form-group mb-2 '>
                                    <label className='form-label'> Item Name </label>
                                    <input
                                    type='text'
                                    placeholder="Enter First Name"
                                    name = "name"
                                    className='form-control'
                                    value={name}
                                    onChange={(e) => setname(e.target.value)}>
                                    </input>
                                </div>
                                <br/>
                                <br/>
                                <br/>
                                <button className='btn btn-success' onClick={(e) => saveOrUpdateItem(e)}>
                                    Submit
                                </button>
                                <Link to='/assign-unassign-item' className='btn btn-danger'>
                                    Cancel
                                </Link>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default AddItem;