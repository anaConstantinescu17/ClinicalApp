import ReactDOM from "react-dom";

const { Component } = require('react');
const React = require('react');
import DepartmentList from './DepartmentList'

console.log("here before APP");
class App extends Component {

	constructor(props) {
		console.log("run App constructor()")
		super(props);
		this.state = {departments: [
				{
					"name": "ORL",
					"description": "Orl description",
				},
				{
					"name": "Stomatologie",
					"description": "Stomatologie description",
				}
			]};
		console.log(this.state.departments);
	}

	componentDidMount() {
		/*client({method: 'GET', path: '/api/department/all'}).done(response => {
			this.setState({departments: response});
		});*/
	}

	render() {
		console.log("run App render()");
		return (
		    <div>DepartmentList
			    <DepartmentList departments={this.state.departments}/>
			</div>
		)
	}
}

ReactDOM.render(<App/>,document.getElementById('react'));

