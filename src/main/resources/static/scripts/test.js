let count = 0;

function showAlert(attr) {
    alert("test " + attr + " !!!!!!!!");
    count = count + 1
    document.getElementById('lbl').innerHTML = 'test passed ' + count + ' times' ;

}