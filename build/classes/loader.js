const url = 'http://localhost:8080/service/users';
const body = document.getElementsByClassName('body');
const table = document.createElement('table');
table.id = 'usersTable';
body.appendChild(table);

const getUsers = () => {
    fetch(url)
        .then((responce) => responce.json())
        .then((users) => {
            for (let index = 0; index < users.length; index++) {
                table.insertRow(-1).innerHTML = '<td>'+users[index].id+'</td>'+'<td>'+users[index].name+'</td>';
            }
    })
}