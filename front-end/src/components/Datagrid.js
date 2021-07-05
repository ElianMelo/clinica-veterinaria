import React, { Component } from 'react';
import { Table } from 'react-bootstrap';

class Datagrid extends Component {
    constructor(props) {
        super(props);

        this.state = {
            metadados: {
                props: [],
                values: []
            }
        }
    }

    componentDidMount() {
        var metadados = {};

        metadados.props = [];
        metadados.values = [];

        for(let [prop, value] of Object.entries(this.props.metadados)) {
            metadados.props.push(prop);
            metadados.values.push(value);
        }

        this.setState({metadados: metadados});
    }

    render() {
        return (
            <div>
                <h2>{this.props.titulo}</h2>
                <Table striped bordered hover>
                    <thead>
                        <tr>
                            {
                                this.state.metadados.values.map((el) => {
                                    return <th>{el}</th>
                                })
                            }
                        </tr>
                    </thead>
                    <tbody>
                            {
                                this.props.dados.map((el) => {
                                    return <tr>
                                    {
                                        this.state.metadados.props.map((prop) => {
                                            return <td>{el[prop] === true ? <span>Sim</span> : el[prop] === false ? <span>Não</span> : el[prop]}</td>
                                        })
                                    }
                                    </tr>
                                })
                            }
                    </tbody>
                </Table>
            </div>
        );
    }
}

export default Datagrid;