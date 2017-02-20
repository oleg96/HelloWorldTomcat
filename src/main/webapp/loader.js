const url = 'http://localhost:8080/HelloWorldTomcat/service/users';
const body = document.getElementsByTagName("body")[0];
const usersTable = document.createElement('table');
body.appendChild(usersTable);

const getUsers = () => {
	usersTable.innerHTML = '';
	usersTable.insertRow(-1).innerHTML = '<tr><th>User Id</th><th>User Name</th></tr>';
    fetch(url)
        .then((responce) => responce.json())
        .then((users) => {
            for (let index = 0; index < users.length; index++) {
            	usersTable.insertRow(-1).innerHTML = '<tr><td>'+users[index].id+'</td>'+'<td>'+users[index].name+'</td></tr>';
            }
    })
    .catch(error => {
        alert('Request failed: ' + error);
    });
};