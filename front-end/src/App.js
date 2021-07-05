import React, { Component } from 'react';
import Home from './components/Home';
import Fluxo from './components/Fluxo';
import 'bootstrap/dist/css/bootstrap.min.css';
import {
  BrowserRouter as Router,
  Switch,
  Route,
  Link
} from "react-router-dom";
import { Nav, Navbar } from 'react-bootstrap';


class App extends Component {
  render() {
    return (
      <div>
        <Router>
        <Navbar bg="light" expand="lg">
          <Navbar.Brand>Clinica Veterinária</Navbar.Brand>
          <Navbar.Toggle aria-controls="basic-navbar-nav" />
          <Navbar.Collapse id="basic-navbar-nav">
            <Nav className="mr-auto">
              <Nav.Link>
                <Link to="/">Inicio</Link>
              </Nav.Link>
              <Nav.Link>
                <Link to="/fluxo">Fluxo</Link>
              </Nav.Link>
            </Nav>
          </Navbar.Collapse>
        </Navbar>

          <div className="container">
            <Switch>
              <Route exact path="/">
                <h1>Home</h1>
                <Home></Home>
              </Route>
              <Route path="/fluxo">
                <h1>Guaxinim</h1>
                <Fluxo></Fluxo>
              </Route>
            </Switch>
          </div>
        </Router>
      </div>
    );
  }
}

export default App;