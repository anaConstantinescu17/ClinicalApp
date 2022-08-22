const { Component } = require("react");
import Department from './Department';


export default class DepartmentList extends Component{
	render() {
		const departments = this.props.departments.forEach(department =>
			<Department key={department.name} department={department}/>
		);
		return (
			<table>
				<tbody>
					<tr>
						<th>Name</th>
						<th>Description</th>
					</tr>
					{departments}
				</tbody>
			</table>
		)
	}
}