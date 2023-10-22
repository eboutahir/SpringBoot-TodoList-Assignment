import React, { useState, useEffect } from 'react';
import Swal from 'sweetalert2';
import axios from 'axios';
import {
  Table,
  Paper,
  Button,
  TextField,
  DialogActions,
  Dialog,
  DialogContent,
  DialogTitle,
  TableRow,
  TableBody,
  TableCell,
  Container,
  Typography,
  TableContainer,
} from '@mui/material';
import { TableHead } from '@mui/material';

const TaskList = () => {
  const [userData, setUserData] = useState([]);
  const [open, setOpen] = useState(false);
  const [title, setTitle] = useState('');
  const [description, setDescription] = useState('');
  const [taskId, setTaskId] = useState(null);
  const fetchDataFromDatabase = async () => {
    try {
      const response = await fetch('http://localhost:9090/api/getAlltasks');
      const data = await response.json();
      setUserData(data);
    } catch (error) {
      console.error('Error fetching data:', error);
      setUserData([]);
    }
  };
  const handleOpen = () => {
    if (taskId) {
      setTitle('');
      setDescription('');
      setTaskId(null);
    }
    setOpen(true);
  };

  useEffect(() => {
    
    fetchDataFromDatabase();
  }, []);



  const handleClose = () => {
    setOpen(false);
  };

  const saveTask = () => {
    fetch('http://localhost:9090/api/addTask', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({ title, description }),
    })
      .then((response) => response.json())
      .then((data) => {
        fetchDataFromDatabase();
        handleClose();
      })
      .catch((error) => {
        console.error('Error:', error);
      });
  };

  const editTask = (id) => {
    setTaskId(id);
    const taskToEdit = userData.find((task) => task.id === id);
    if (taskToEdit) {
      setTitle(taskToEdit.title);
      setDescription(taskToEdit.description);
      setOpen(true); 
    }
  };

  const updateTask = () => {
    if (taskId) {
      axios
        .post(`http://localhost:9090/api/updateTask/${taskId}`, {
          title,
          description,
        })
        .then((response) => {
          fetchDataFromDatabase();
          handleClose();
        })
        .catch((error) => {
          console.error('Error:', error);
        });
    }
  };

  const deleteTask = (id) => {
    axios
      .delete(`http://localhost:9090/api/deleteTaskById/${id}`)
      .then((response) => {
        const updatedUserData = userData.filter((task) => task.id !== id);
        setUserData(updatedUserData);
        Swal.fire('Succès', 'Tâche supprimée avec succès', 'success');
      })
      .catch((error) => {
        console.error('Erreur lors de la suppression de la tâche:', error);
        console.log(error.response);
        Swal.fire('Erreur', 'Erreur lors de la suppression de la tâche', 'error');
      });
  };

  return (
    <Container>
      <Typography variant="h4" gutterBottom style={{ color: 'blue', marginTop: '20px' }}>
        Liste des tâches
      </Typography>
      <Button variant="contained" onClick={handleOpen} style={{ marginBottom: '20px' }}>
        Ajouter une Tâche
      </Button>
      <TableContainer component={Paper}>
        <Table>
          <TableHead>
            <TableRow>
              <TableCell>Titre</TableCell>
              <TableCell>Description</TableCell>
              <TableCell>Action</TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {Array.isArray(userData) &&
              userData.map((task) => (
                <TableRow key={task.id}>
                  <TableCell>{task.title}</TableCell>
                  <TableCell>{task.description}</TableCell>
                  <TableCell align="center">
                    <Button
                      variant="contained"
                      color="primary"
                      onClick={() => editTask(task.id)}
                      style={{ marginRight: '10px' }}
                    >
                      Modifier
                    </Button>
                    <Button
                      variant="contained"
                      color="secondary"
                      onClick={() => deleteTask(task.id)}
                    >
                      Supprimer
                    </Button>
                  </TableCell>
                </TableRow>
              ))}
          </TableBody>
        </Table>
      </TableContainer>
      <Dialog open={open} onClose={handleClose}>
        <DialogTitle>{taskId ? 'Modifier une tâche' : 'Ajouter une tâche'}</DialogTitle>
        <DialogContent>
          <TextField
            autoFocus
            margin="dense"
            id="title"
            label="Titre"
            type="text"
            fullWidth
            value={title}
            onChange={(e) => setTitle(e.target.value)}
          />
          <TextField
            margin="dense"
            id="description"
            label="Description"
            type="text"
            fullWidth
            value={description}
            onChange={(e) => setDescription(e.target.value)}
          />
        </DialogContent>
        <DialogActions>
          <Button onClick={handleClose} color="primary">
            Annuler
          </Button>
          <Button onClick={taskId ? updateTask : saveTask} color="primary">
            {taskId ? 'Modifier' : 'Enregistrer'}
          </Button>
        </DialogActions>
      </Dialog>
    </Container>
  );
};

export default TaskList;
