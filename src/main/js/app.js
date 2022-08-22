const { Component } = require('react');
const React = require('react');
const ReactDOM = require('react-dom');
import DepartmentList from './DepartmentList'

console.log("here");
class App extends Component {

	constructor(props) {
		super(props);
		this.state = {departments: []};
	}

	componentDidMount() {
		client({method: 'GET', path: '/api/department/all'}).done(response => {
			this.setState({departments: response});
		});
	}

	render() {
		return (
		    <div>DepartmentList
			    <DepartmentList departments={this.state.departments}/>
			</div>
		)
	}
}

