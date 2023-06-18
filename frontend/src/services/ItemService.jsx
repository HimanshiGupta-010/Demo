import axios from "axios";

const ITEM_BASE_REST_API_URL = "http://localhost:8080/items";

class ItemServices {
  getAllItems() {
    return axios.get(ITEM_BASE_REST_API_URL);
  }

  createItem(Item) {
    return axios.post(ITEM_BASE_REST_API_URL, Item);
  }

  getItemById(ItemId) {
    return axios.get(ITEM_BASE_REST_API_URL + "/" + ItemId);
  }

  updateItem(ItemId, Item) {
    return axios.put(ITEM_BASE_REST_API_URL + "/" + ItemId, Item);
  }

  updateStatus(ItemId)
{
  return axios.put(ITEM_BASE_REST_API_URL + "/status/" + ItemId);
}

  deleteItem(ItemId) {
    return axios.delete(ITEM_BASE_REST_API_URL + "/" + ItemId);
  }
  updateEmployee(employeeId, employee) {
    return axios.put("http://localhost:8080/items/Eapi/" + employeeId, employee);
  }
}



export default new ItemServices();
