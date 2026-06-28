import { useNavigate } from 'react-router-dom';
export default function ProfilePage() { 
  const nav = useNavigate();
  return <div className="glass-card"><h2 className="text-primary mb-md">Profile</h2><button className="btn btn-secondary" onClick={() => nav('/profile/edit')}>Edit Profile</button></div>; 
}
