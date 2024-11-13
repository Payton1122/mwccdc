//Event Listeners

document.addEventListener("DOMContentLoaded", () => {
	
    const addButton = document.getElementById("addButton");
    const rewardButton = document.getElementById("rewardButton");
    const importButton = document.getElementById("importButton");
    const importAppendButton = document.getElementById("importAppendButton");
    const fileInput = document.getElementById("fileInput");
    const fileAppendInput = document.getElementById("fileAppendInput");

    if (addButton) {
        addButton.addEventListener("click", addData);
    }
    
    if (rewardButton) {
        rewardButton.addEventListener("click", initiateRewardProcess);
    }

    if (importButton) {
        importButton.addEventListener('click', () => {
            fileInput && fileInput.click(); 
        });
    }

    if (importAppendButton) {
        importAppendButton.addEventListener('click', () => {
            fileAppendInput && fileAppendInput.click();
        });
    }

    if (fileInput) {
        fileInput.addEventListener('change', (event) => {
            importData(event, true);
        });
    }

    if (fileAppendInput) {
        fileAppendInput.addEventListener('change', (event) => {
            importData(event, false);
        });
    }
});


async function initiateRewardProcess() {
	
	try{
		await assignRewards();
		await goToRewardPage();
	} catch(error) {
		alert("There was an error assigning rewards")
	}
	
}


async function goToRewardPage() {
	window.location.href = '/Project-1-reward';
}

async function assignRewards() {
	$.ajax({
		type: 'POST',
		url: '/api/assignRewards',
		contentType: 'application/json', 
		success: function (result) {
			if (result.code == "success") {
				alert("Success: " + result.code)
			} else {
				alert("Failed: " + result.code);
			}
		},
		error: function (error) {
			alert('Error: ' + error.responseJSON.error);
		}
	});
}


function importData(event, truncTable) {
	
	const file = event.target.files[0];
		    if (file) {
				 
				var jsonData;
				const reader = new FileReader();
				try {
					reader.onload = function(event) {
						const content = event.target.result;
					  	
						//dupe check		
						const seenNames = [];
						const duplicates = [];
						
						try {
						  	jsonData = JSON.parse(content);
							
							jsonData.forEach(jsonData => {
								const nameKey = `${jsonData.firstName.toLowerCase()} ${jsonData.lastName.toLowerCase()}`;
								
								console.log(seenNames);
								console.log(nameKey);
								console.log(duplicates);
								
								if (seenNames.includes(nameKey) && seenNames.length > 0) {
									console.log("added dupe")
								    duplicates.push(nameKey); 
								} else {
									console.log("added name")
								   	seenNames.push(nameKey);
								}
								
							});
							console.log('Parsed JSON data:', jsonData);
						} catch (error) {
							console.log('Error parsing JSON:', error);
						}
						
						if (truncTable) {
							url = '/api/upload'
						} else {
							url = '/api/append'
						}
						
						if (duplicates.length == 0) {
					        $.ajax({
					            type: 'POST',
					            url: url,
					            data: JSON.stringify(jsonData),
					            contentType: 'application/json', 
					            success: function (response) {
									const result = JSON.parse(response);
									if (result.code === "success") {
									    alert("Success");
									} else {
									    alert("Failed: " + result.code);
									}
					            },
					            error: function (error) {
					                alert('Error: ' + error.responseJSON.error);
					            }
					        });
					    } else {
							alert("Duplicate records in json file");
						}
					}
					} catch (error) {
						console.log("could not send request");
					}
					reader.readAsText(file);
				}
}


function addData() {

	const formData = {
		firstName: $('#fNameInput').val(),
		lastName: $('#lNameInput').val(),
	   	email: $('#email').val(),
	   	phone: $('#phoneNum').val(),
	   	firstOccupation: $('#fOccupation').val(),
	   	preferredStand: $('#pStand').val(),
	   	reservationTime: $('#resTime').val(),
	 };
			
			
	 var isEmpty = Object.values(formData).some(value => value.trim() === '');

	 if (isEmpty) {
		alert('Please fill in all fields.');
		return;
	 }
	
	 $.ajax({
	    type: 'POST',
	    url: '/api/insertFan',
	    data: JSON.stringify(formData),
	    contentType: 'application/json',
	    success: function (response) {
	         alert(response.message);
	    },
	    error: function (error) {
	         alert('Error: ' + error.responseJSON.error);
	    }
	 });
}

