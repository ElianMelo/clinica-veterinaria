import React, { Component } from 'react';
import SpecificDataset from './SpecificDataset';
import Datagrid from './Datagrid';

class Fluxo extends Component {
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
                <SpecificDataset
                  endpoint="animal"
                  opt="/4"
                  change={this.change}
                />
                <SpecificDataset
                  endpoint="consulta"
                  opt="/id=4"
                  change={this.change}
                />,
                <SpecificDataset
                  endpoint="exame"
                  opt="/id=4"
                  change={this.change}
                />
                <SpecificDataset
                  endpoint="anamnese"
                  opt="/7"
                  change={this.change}
                />
                <SpecificDataset
                  endpoint="doenca"
                  opt="4"
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
            </div>
        );
    }
}

export default Fluxo;