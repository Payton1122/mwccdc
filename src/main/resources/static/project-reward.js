let rewardsArray = []

document.addEventListener("DOMContentLoaded", () => {
	
});


function filterTable() {
    var input, filter, table, rows, td, i, j, txtValue;
    input = document.getElementById("filterInput");
    filter = input.value.toUpperCase(); 
    table = document.getElementById("rewardedFansTable");
    rows = table.getElementsByTagName("tr");

	
    for (i = 1; i < rows.length; i++) {
        rows[i].style.display = "none"; 
        td = rows[i].getElementsByTagName("td");

        for (j = 0; j < td.length; j++) {
            if (td[j]) {
                txtValue = td[j].textContent || td[j].innerText;
                if (txtValue.toUpperCase().indexOf(filter) > -1) {
                    rows[i].style.display = ""; 
                    break; 
                }
            }
        }
    }
}