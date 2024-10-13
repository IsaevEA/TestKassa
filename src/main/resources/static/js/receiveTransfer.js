document.getElementById('receiveTransferForm').addEventListener('submit', function(event) {
    event.preventDefault();

    const transactionCode = document.getElementById('transactionCode').value;

    fetch(`http://localhost:8080/api/transactions/receive/${transactionCode}`, {
        method: 'GET'
    })
        .then(response => response.json())
        .then(data => {
            if (data.status === 'TRANSACTION_SUCCESSFUL') {
                alert('Перевод получен!');
            } else {
                alert('Ошибка при получении перевода. Проверьте код.');
            }
        })
        .catch(error => console.error('Ошибка:', error));
});
