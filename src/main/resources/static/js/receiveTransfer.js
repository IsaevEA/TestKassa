document.getElementById('receiveTransferForm').addEventListener('submit', function(event) {
    event.preventDefault();

    const transactionsCode = document.getElementById('transactionsCode').value;

    fetch(`http://localhost:8080/transactions/${transactionsCode}`, {
        method: 'GET'
    })
        .then(response => response.json())
        .then(data => {
            if (data.status === 'CREATED') {
                alert('Перевод получен!');
            } else {
                alert('Ошибка при получении перевода. Проверьте код.');
            }
        })
        .catch(error => console.error('Ошибка:', error));
});
