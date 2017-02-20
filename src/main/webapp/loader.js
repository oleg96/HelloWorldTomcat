const url = 'http://localhost:8080/HelloWorldTomcat/service/users';
var body = document.getElementsByTagName("body")[0];
var userTable = document.createElement('table');
userTable.id = 'usersTable';
body.appendChild(userTable);

const getUsers = () => {
    fetch(url)
        .then((responce) => responce.json())
        .then((users) => {
            for (let index = 0; index < users.length; index++) {
                userTable.insertRow(-1).innerHTML = '<td>'+users[index].id+'</td>'+'<td>'+users[index].name+'</td>';
            }
    })
    .catch(function (error) {
        alert('Request failed: ' + error);
    });
};