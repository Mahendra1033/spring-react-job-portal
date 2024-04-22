import {
    Route,
    createBrowserRouter,
    createRoutesFromElements,
    RouterProvider
} from 'react-router-dom'

import HomePage from "./pages/HomePage.jsx";
import MainLayout from "./layouts/MainLayout.jsx";
import JobsPage from "./pages/JobsPage.jsx";
import NotFoundPage from "./pages/NotFoundPage.jsx";
import JobPage, {jobLoader} from "./pages/JobPage.jsx";
import AddJobPage from "./pages/AddJobPage.jsx";
import EditJobPage from "./pages/EditJobPage.jsx";

const App = () => {

    //add new job
    const addJob = async (newJob) => {
        const response = await fetch('/baseUrl/api/v1/jobs/add', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(newJob),
        });
        return;
    }

    //delete job
    const deleteJob = async (id) => {
        const response = await fetch(`/baseUrl/api/v1/jobs/${id}`, {
            method: 'DELETE',
        });
        return;
    }

    //update job
    const updateJob = async (job) => {
        const response = await fetch('/baseUrl/api/v1/jobs/update', {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(job),
        });
        return;
    }

    const router = createBrowserRouter(
        createRoutesFromElements(
            <Route path="/" element={<MainLayout/>}>
                <Route index element={<HomePage/>}/>
                <Route path="/jobs" element={<JobsPage/>}/>
                <Route path="/jobs/:id" element={<JobPage deleteJob={ deleteJob }/>}
                       loader={jobLoader}/>
                <Route path="/add-job" element={<AddJobPage addJobSubmit={addJob}/>}/>
                <Route path="/edit-job/:id" element={<EditJobPage updateJobSubmit={updateJob}/>}
                       loader={jobLoader}/>
                <Route path="*" element={<NotFoundPage/>}/>
            </Route>
        )
    )

    return <RouterProvider router={router}/>;
};

export default App;