import { useNavigate } from 'react-router-dom';
export default function EditProfilePage() { 
  const nav = useNavigate();
  return <div className="glass-card m-lg"><h2 className="text-primary mb-md">Edit Profile</h2><button className="btn btn-primary" onClick={() => nav(-1)}>Save Changes</button></div>; 
}
