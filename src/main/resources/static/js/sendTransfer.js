document.getElementById('sendTransferForm').addEventListener('submit', function(event) {
    event.preventDefault();

    const senderName = document.getElementById('senderName').value;
    const receiverName = document.getElementById('receiverName').value;
    const soursNumber = document.getElementById('soursNumber').value;
    const targetNumber = document.getElementById('targetNumber').value;
    const amount = document.getElementById('amount').value;
    const description = document.getElementById('description').value;
    const transactionCode = document.getElementById('transactionsCode').value;

    const data = {
        senderName,
        receiverName,
        soursNumber,
        targetNumber,
        amount,
        description
    };

    fetch('http://localhost:8080/transactions/create', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
        .then(response => response.json())
        .then(data => {
            if (data.message === 'TRANSACTION_SUCCESSFUL') {
                alert('Перевод успешно отправлен! Код транзакции: ' + data.transactionCode);
            } else {
                alert('Ошибка при отправке перевода.');
            }
        })
        .catch(error => console.error('Ошибка:', error));
});