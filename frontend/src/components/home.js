import '../App.css';
import {Component} from "react";
import Button from '@mui/material/Button';
import axios from 'axios';
import authHeader from "../services/auth-header";

const ariaLabel = { 'aria-label': 'description' };

const user = JSON.parse(localStorage.getItem("user"));

  const initialState = user
    ? { isLoggedIn: true, user }
    : { isLoggedIn: false, user: null };

class Home extends Component {
  state = {
    items: []
  };

  async componentDidMount() {
    const response = await axios.get("http://localhost:8081/api/inventory/all", { headers: authHeader() });
    const body = await response.data;
    this.setState({items: body});
  }

  deleteProduct(id) {
    axios.delete('http://localhost:8081/api/inventory/'+id)
        .then(() => this.setState({ status: 'Delete successful' }));
  };

  render() {
    const {items} = this.state;

    return (
        <div className="App">
          <h1>Item List <Button variant="contained">Add New product</Button> </h1>
            {items.map(item =>
                <div key={item.id}>
                  Id: {item.id} Name: {item.product.name}  Description: {item.product.description} Amount: {item.amount} <Button variant="contained">Edit</Button> <Button onClick={() => {this.deleteProduct(item.id)}} variant="contained">Delete</Button>
                </div>
            )}
        </div>
    );
  }
}
export default Home;