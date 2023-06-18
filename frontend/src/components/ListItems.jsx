import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import ItemServices from "../services/ItemService";

const ListItem = () => {    
    const [Item, setItem] = useState([]);
        
    useEffect(() => {
        getAllItems();
    });

    const getAllItems = () => {
        ItemServices.getAllItems().then((response) => {
            setItem(response.data);
            console.log(response.data);
        })
        .catch((error) => {
            console.log(error);
        });
    };
  
    const deleteItem = (ItemId) => {
        ItemServices.deleteItem(ItemId).then((response) => {
            getAllItems();
        })
        .catch((error) => {
            console.log(error);
      });
  };

    return (
      <div className="container">
        <h2 className="text-center"> List Items </h2>
          <Link to="/add-Item" className="btn btn-primary mb-2">
              Add Items
          </Link>
          <table className="table table-bordered table-striped">
              <thead>
                  <th> Item Id </th>
                  <th> Item Name </th>
                  {/* <th> Status </th> */}
                  <th>Actions</th>
              </thead>
              <tbody>
                  {Item.map((Item) => (
                      <tr key={Item.item_id}>
                          <td> {Item.item_id} </td>
                          <td> {Item.name} </td>
                          {/* <td> {Item.status} </td> */}
                          <td>
                              <Link className="btn btn-info" to={`/edit-item/${Item.item_id}`}>
                                  Update
                              </Link>
                              <button className="btn btn-danger" onClick={() => deleteItem(Item.item_id)} 
                                  style={{ marginLeft: "10px" }}>
                                  Delete
                              </button>
                          </td>
                      </tr>
                  ))}
              </tbody>
          </table>
      </div>
    );
};

export default ListItem;