const { Component } = require("react");

class Department extends Component{
	render() {
		return (
			<tr>
				<td>{this.props.department.name}</td>
				<td>{this.props.department.description}</td>
			</tr>
		)
	}
}
export default Department;