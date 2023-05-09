# onedata_employee_management_system
This is a simple website where I integrate the boot restapi in reactApp

#command to run ReactApp   projectNamd- Onedatadashboard
docker run -it -p 4001:3000 client

# Commnd to run SprinBootApi  
docker run --network springboot-mysql-net --name onedata-emp-mysql-container -p 8080:8080 onedata-emp

#  remove container name
docker run --network springboot-mysql-net  -p 8080:8080 onedata-emp
