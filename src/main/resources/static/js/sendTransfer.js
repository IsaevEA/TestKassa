document.getElementById('sendTransferForm').addEventListener('submit', function(event) {
    event.preventDefault();

    const senderName = document.getElementById('senderName').value;
    const receiverName = document.getElementById('receiverName').value;
    const senderPhone = document.getElementById('senderPhone').value;
    const receiverPhone = document.getElementById('receiverPhone').value;
    const amount = document.getElementById('amount').value;
    const description = document.getElementById('description').value;

    const data = {
        senderName,
        receiverName,
        senderPhone,
        receiverPhone,
        amount,
        description
    };

    fetch('http://localhost:8080/transactions/create', { // Измененный URL
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
        .then(response => response.json())
        .then(data => {
            if (data.status === 'TRANSACTION_SUCCESSFUL') {
                alert('Перевод успешно отправлен! Код транзакции: ' + data.transactionCode);
            } else {
                alert('Ошибка при отправке перевода.');
            }
        })
        .catch(error => console.error('Ошибка:', error));
});
