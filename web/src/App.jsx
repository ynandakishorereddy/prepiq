import { BrowserRouter as Router, Routes, Route, Navigate } from 'react-router-dom';
import SplashPage from './pages/SplashPage';
import LoginPage from './pages/LoginPage';
import SignupPage from './pages/SignupPage';
import DashboardLayout from './components/layout/DashboardLayout';
import HomePage from './pages/HomePage';
import PracticePage from './pages/PracticePage';
import RemindersPage from './pages/RemindersPage';
import ProfilePage from './pages/ProfilePage';
import EditProfilePage from './pages/EditProfilePage';
import AnswerScreen from './pages/AnswerScreen';
import SessionSummaryScreen from './pages/SessionSummaryScreen';
import MatchScoreScreen from './pages/MatchScoreScreen';
import ResumeRewritesScreen from './pages/ResumeRewritesScreen';

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<SplashPage />} />
        <Route path="/login" element={<LoginPage />} />
        <Route path="/signup" element={<SignupPage />} />
        
        {/* Dashboard Layout with Sidebar/Bottom Nav */}
        <Route path="/dashboard" element={<DashboardLayout />}>
          <Route index element={<Navigate to="/dashboard/home" replace />} />
          <Route path="home" element={<HomePage />} />
          <Route path="practice" element={<PracticePage />} />
          <Route path="reminders" element={<RemindersPage />} />
          <Route path="profile" element={<ProfilePage />} />
        </Route>

        {/* Full screen flows */}
        <Route path="/profile/edit" element={<EditProfilePage />} />
        
        {/* Interview & Practice Flows */}
        <Route path="/practice/answer" element={<AnswerScreen />} />
        <Route path="/practice/summary" element={<SessionSummaryScreen />} />
        <Route path="/match-score" element={<MatchScoreScreen />} />
        <Route path="/resume-rewrites" element={<ResumeRewritesScreen />} />
        
        {/* Catch all */}
        <Route path="*" element={<Navigate to="/" replace />} />
      </Routes>
    </Router>
  );
}

export default App;
