import React, { Component } from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import Datagrid from './components/Datagrid';
import Dataset from './components/Dataset';
import {
  BrowserRouter as Router,
  Switch,
  Route,
  Link
} from "react-router-dom";
import { Nav, Navbar } from 'react-bootstrap';


class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      animal: [],
      consulta: [],
      exame: [],
      anamnese: [],
      doenca: [],
    }
    this.change = this.change.bind(this);

    this.animalMetadata = {
      id: "Id",
      dataCadastro: "Data Cadastro",
      dataNascimento: "Data Nascimento",
      estado: "Estado",
      foto: "Foto",
      nome: "Nome",
      pelagem: "Pelagem",
      peso: "Peso",
      raca: "Raça",
      tipo: "Tipo"
    }

    this.consultaMetadata = {
      id: "Id",
      date: "Data",
      historico: "Historico",
      observacoes: "Observacoes",
      queixa: "Queixa"
    }

    this.doencaMetadata = {
      id: "Id",
      nome: "Tétano"
    }

    this.exameMetadata = {
      id: "Id",
      calcio: "Calcio",
      colesterol: "Colesterol",
      date: "Data Atendimento",
      fosforo: "Fósforo",
      glicose: "Glicose",
      hemograma: "Hemograma",
      magnesio: "Magnésio",
      potassio: "Potássio",
      radiografia: "Radiografia",
      ultrassonografia: "Ultrassonografia",
      ureia: "Ureia"
    }

    this.anamneseMetadata = {
      id: "Id",
      problemaOlhos: "Olhos",
      problemaOuvido: "Ouvido",
      problemaPele: "Pele",
      problemaSistemaCardioRespiratorio: "Cardio Respiratório",
      problemaSistemaDigestivo: "Digestivo",
      problemaSistemaLocomotor: "Locomotor",
      problemaSistemaNeurologico: "Neurologico",
      problemaSistemaUroGenital: "Uro Genital"
    }

  }

  change(key, value) {
    this.setState({ [key]: value });
  }

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
                <Dataset
                  endpoint="animal"
                  change={this.change}
                />
                <Dataset
                  endpoint="consulta"
                  change={this.change}
                />,
                <Dataset
                  endpoint="exame"
                  change={this.change}
                />
                <Dataset
                  endpoint="anamnese"
                  change={this.change}
                />
                <Dataset
                  endpoint="doenca"
                  change={this.change}
                />


                <Datagrid
                  titulo="Animal"
                  dados={this.state.animal}
                  metadados={this.animalMetadata}
                />
                <Datagrid
                  titulo="Consulta"
                  dados={this.state.consulta}
                  metadados={this.consultaMetadata}
                />
                <Datagrid
                  titulo="Exame"
                  dados={this.state.exame}
                  metadados={this.exameMetadata}
                />
                <Datagrid
                  titulo="Anamnese"
                  dados={this.state.anamnese}
                  metadados={this.anamneseMetadata}
                />
                <Datagrid
                  titulo="Doenca"
                  dados={this.state.doenca}
                  metadados={this.doencaMetadata}
                />
              </Route>
              <Route path="/fluxo">
                <h1>Guaxinim</h1>
              </Route>
            </Switch>
          </div>
        </Router>
      </div>
    );
  }
}

export default App;